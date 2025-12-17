import AsyncStorage from '@react-native-async-storage/async-storage';
import { CalendarEvent, CreateCalendarEventInput } from '../models/CalendarEvent';

const STORAGE_KEY = 'daymate.events.v1';

type EventsByDate = Record<string, CalendarEvent[]>;

const safeJsonParse = <T>(raw: string | null): T | null => {
    if (!raw) return null;
    try {
        return JSON.parse(raw) as T;
    } catch {
        return null;
    }
};

const generateId = (): string => {
    return `${Date.now()}-${Math.random().toString(16).slice(2)}`;
};

const normalizeTime = (value?: string): string | undefined => {
    if (!value) return undefined;
    const trimmed = value.trim();
    return trimmed.length ? trimmed : undefined;
};

export class EventStorage {
    static async getAllEventsByDate(): Promise<EventsByDate> {
        const raw = await AsyncStorage.getItem(STORAGE_KEY);
        const parsed = safeJsonParse<EventsByDate>(raw);
        if (!parsed || typeof parsed !== 'object') return {};
        return parsed;
    }

    static async getEventsForDate(date: string): Promise<CalendarEvent[]> {
        const all = await EventStorage.getAllEventsByDate();
        return all[date] ?? [];
    }

    static async addEvent(input: CreateCalendarEventInput): Promise<CalendarEvent> {
        const now = new Date().toISOString();
        const event: CalendarEvent = {
            id: generateId(),
            date: input.date,
            title: input.title.trim(),
            startTime: normalizeTime(input.startTime),
            endTime: normalizeTime(input.endTime),
            notes: normalizeTime(input.notes),
            createdAt: now,
            updatedAt: now,
        };

        const all = await EventStorage.getAllEventsByDate();
        const nextForDate = [...(all[input.date] ?? []), event];
        all[input.date] = nextForDate;

        await AsyncStorage.setItem(STORAGE_KEY, JSON.stringify(all));
        return event;
    }
}

export type { EventsByDate };
