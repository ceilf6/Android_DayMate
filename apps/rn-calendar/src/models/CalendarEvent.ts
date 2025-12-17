export type CalendarEvent = {
    id: string;
    date: string; // yyyy-MM-dd
    title: string;
    startTime?: string; // HH:mm
    endTime?: string; // HH:mm
    notes?: string;
    createdAt: string; // ISO string
    updatedAt: string; // ISO string
};

export type CreateCalendarEventInput = {
    date: string;
    title: string;
    startTime?: string;
    endTime?: string;
    notes?: string;
};
