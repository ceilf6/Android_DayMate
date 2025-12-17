import React, { useEffect, useMemo, useState } from 'react';
import {
    SafeAreaView,
    ScrollView,
    StyleSheet,
    Text,
    TextInput,
    View,
    Modal,
    TouchableOpacity,
    useColorScheme,
} from 'react-native';
import { Calendar } from 'react-native-calendars';

import type { CalendarEvent } from '../models/CalendarEvent';
import { EventStorage } from '../services/EventStorage';

const HomeScreen = () => {
    const isDarkMode = useColorScheme() === 'dark';
    const [selectedDate, setSelectedDate] = useState('');
    const [eventsByDate, setEventsByDate] = useState<Record<string, CalendarEvent[]>>({});

    const [isAddModalVisible, setIsAddModalVisible] = useState(false);
    const [newTitle, setNewTitle] = useState('');
    const [newStartTime, setNewStartTime] = useState('');
    const [newEndTime, setNewEndTime] = useState('');
    const [newNotes, setNewNotes] = useState('');
    const [formError, setFormError] = useState('');

    useEffect(() => {
        let isMounted = true;
        (async () => {
            const all = await EventStorage.getAllEventsByDate();
            if (isMounted) setEventsByDate(all);
        })();
        return () => {
            isMounted = false;
        };
    }, []);

    const onDayPress = (day: any) => {
        setSelectedDate(day.dateString);
    };

    const selectedEvents = useMemo(() => {
        const list = eventsByDate[selectedDate] ?? [];
        return [...list].sort((a, b) => (a.startTime ?? '').localeCompare(b.startTime ?? ''));
    }, [eventsByDate, selectedDate]);

    const markedDates = useMemo(() => {
        const marks: Record<string, any> = {};

        for (const date of Object.keys(eventsByDate)) {
            if ((eventsByDate[date] ?? []).length > 0) {
                marks[date] = {
                    marked: true,
                    dotColor: '#2196F3',
                };
            }
        }

        if (selectedDate) {
            marks[selectedDate] = {
                ...(marks[selectedDate] ?? {}),
                selected: true,
                selectedColor: '#2196F3',
            };
        }

        return marks;
    }, [eventsByDate, selectedDate]);

    const openAddModal = () => {
        if (!selectedDate) return;
        setFormError('');
        setNewTitle('');
        setNewStartTime('');
        setNewEndTime('');
        setNewNotes('');
        setIsAddModalVisible(true);
    };

    const closeAddModal = () => {
        setIsAddModalVisible(false);
        setFormError('');
    };

    const isValidTime = (value: string): boolean => {
        const trimmed = value.trim();
        if (!trimmed) return true;
        return /^([01]\d|2[0-3]):[0-5]\d$/.test(trimmed);
    };

    const onSaveNewEvent = async () => {
        if (!selectedDate) return;
        const title = newTitle.trim();
        if (!title) {
            setFormError('请输入标题');
            return;
        }

        if (!isValidTime(newStartTime) || !isValidTime(newEndTime)) {
            setFormError('时间格式应为 HH:mm');
            return;
        }

        const start = newStartTime.trim();
        const end = newEndTime.trim();
        if (start && end && end < start) {
            setFormError('结束时间不能早于开始时间');
            return;
        }

        const created = await EventStorage.addEvent({
            date: selectedDate,
            title,
            startTime: start,
            endTime: end,
            notes: newNotes.trim(),
        });

        setEventsByDate(prev => {
            const next = { ...prev };
            next[selectedDate] = [...(next[selectedDate] ?? []), created];
            return next;
        });

        closeAddModal();
    };

    return (
        <SafeAreaView style={[styles.container, isDarkMode && styles.containerDark]}>
            <ScrollView contentInsetAdjustmentBehavior="automatic">
                <View style={styles.header}>
                    <Text style={[styles.title, isDarkMode && styles.textDark]}>
                        DayMate 日历
                    </Text>
                    <Text style={[styles.subtitle, isDarkMode && styles.textDark]}>
                        跨平台日程管理
                    </Text>
                </View>

                <Calendar
                    onDayPress={onDayPress}
                    markedDates={markedDates}
                    theme={{
                        backgroundColor: isDarkMode ? '#1a1a1a' : '#ffffff',
                        calendarBackground: isDarkMode ? '#1a1a1a' : '#ffffff',
                        textSectionTitleColor: isDarkMode ? '#b6c1cd' : '#2d4150',
                        selectedDayBackgroundColor: '#2196F3',
                        selectedDayTextColor: '#ffffff',
                        todayTextColor: '#2196F3',
                        dayTextColor: isDarkMode ? '#d9e1e8' : '#2d4150',
                        textDisabledColor: isDarkMode ? '#444444' : '#d9e1e8',
                        monthTextColor: isDarkMode ? '#ffffff' : '#2d4150',
                        arrowColor: isDarkMode ? '#ffffff' : '#2d4150',
                    }}
                />

                {selectedDate ? (
                    <View style={styles.eventSection}>
                        <View style={styles.eventHeaderRow}>
                            <Text style={[styles.eventTitle, isDarkMode && styles.textDark]}>
                                {selectedDate} 的日程
                            </Text>
                            <TouchableOpacity
                                style={styles.addButton}
                                onPress={openAddModal}
                                accessibilityRole="button">
                                <Text style={styles.addButtonText}>添加日程</Text>
                            </TouchableOpacity>
                        </View>

                        {selectedEvents.length === 0 ? (
                            <View style={styles.eventCard}>
                                <Text style={[styles.eventText, isDarkMode && styles.textDark]}>
                                    暂无日程
                                </Text>
                            </View>
                        ) : (
                            <View style={styles.eventList}>
                                {selectedEvents.map(event => (
                                    <View key={event.id} style={styles.eventItem}>
                                        <Text
                                            style={[
                                                styles.eventItemTitle,
                                                isDarkMode && styles.textDark,
                                            ]}
                                            numberOfLines={1}>
                                            {event.title}
                                        </Text>
                                        <Text
                                            style={[
                                                styles.eventItemMeta,
                                                isDarkMode && styles.textDark,
                                            ]}
                                            numberOfLines={1}>
                                            {(event.startTime || event.endTime)
                                                ? `${event.startTime ?? ''}${event.endTime ? ` - ${event.endTime}` : ''}`
                                                : '全天'}
                                        </Text>
                                        {event.notes ? (
                                            <Text
                                                style={[
                                                    styles.eventItemNotes,
                                                    isDarkMode && styles.textDark,
                                                ]}
                                                numberOfLines={2}>
                                                {event.notes}
                                            </Text>
                                        ) : null}
                                    </View>
                                ))}
                            </View>
                        )}
                    </View>
                ) : null}

                <Modal
                    visible={isAddModalVisible}
                    transparent
                    animationType="fade"
                    onRequestClose={closeAddModal}>
                    <View style={styles.modalOverlay}>
                        <View style={styles.modalBackdrop} />
                        <View style={[styles.modalCard, isDarkMode && styles.modalCardDark]}>
                            <Text style={[styles.modalTitle, isDarkMode && styles.textDark]}>
                                添加日程
                            </Text>
                            <Text style={[styles.modalSubtitle, isDarkMode && styles.textDark]}>
                                日期：{selectedDate}
                            </Text>

                            <TextInput
                                value={newTitle}
                                onChangeText={setNewTitle}
                                placeholder="标题（必填）"
                                placeholderTextColor={isDarkMode ? '#b6c1cd' : '#666666'}
                                style={[styles.input, isDarkMode && styles.inputDark]}
                            />
                            <View style={styles.timeRow}>
                                <TextInput
                                    value={newStartTime}
                                    onChangeText={setNewStartTime}
                                    placeholder="开始 HH:mm"
                                    placeholderTextColor={isDarkMode ? '#b6c1cd' : '#666666'}
                                    style={[styles.input, styles.timeInput, isDarkMode && styles.inputDark]}
                                />
                                <TextInput
                                    value={newEndTime}
                                    onChangeText={setNewEndTime}
                                    placeholder="结束 HH:mm"
                                    placeholderTextColor={isDarkMode ? '#b6c1cd' : '#666666'}
                                    style={[styles.input, styles.timeInput, isDarkMode && styles.inputDark]}
                                />
                            </View>
                            <TextInput
                                value={newNotes}
                                onChangeText={setNewNotes}
                                placeholder="备注（可选）"
                                placeholderTextColor={isDarkMode ? '#b6c1cd' : '#666666'}
                                style={[styles.input, styles.notesInput, isDarkMode && styles.inputDark]}
                                multiline
                            />

                            {formError ? (
                                <Text style={styles.formErrorText}>{formError}</Text>
                            ) : null}

                            <View style={styles.modalActions}>
                                <TouchableOpacity
                                    style={[styles.actionButton, styles.cancelButton]}
                                    onPress={closeAddModal}
                                    accessibilityRole="button">
                                    <Text style={styles.cancelButtonText}>取消</Text>
                                </TouchableOpacity>
                                <TouchableOpacity
                                    style={[styles.actionButton, styles.saveButton]}
                                    onPress={onSaveNewEvent}
                                    accessibilityRole="button">
                                    <Text style={styles.saveButtonText}>保存</Text>
                                </TouchableOpacity>
                            </View>
                        </View>
                    </View>
                </Modal>
            </ScrollView>
        </SafeAreaView>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#ffffff',
    },
    containerDark: {
        backgroundColor: '#1a1a1a',
    },
    header: {
        padding: 20,
        alignItems: 'center',
    },
    title: {
        fontSize: 24,
        fontWeight: 'bold',
        color: '#000000',
    },
    subtitle: {
        fontSize: 14,
        color: '#666666',
        marginTop: 5,
    },
    textDark: {
        color: '#ffffff',
    },
    eventSection: {
        padding: 20,
    },
    eventHeaderRow: {
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'space-between',
        marginBottom: 10,
    },
    eventTitle: {
        fontSize: 18,
        fontWeight: 'bold',
        color: '#000000',
    },
    addButton: {
        paddingHorizontal: 12,
        paddingVertical: 8,
        backgroundColor: '#2196F3',
        borderRadius: 8,
    },
    addButtonText: {
        color: '#ffffff',
        fontSize: 14,
        fontWeight: '600',
    },
    eventCard: {
        backgroundColor: '#f5f5f5',
        padding: 15,
        borderRadius: 8,
    },
    eventText: {
        fontSize: 14,
        color: '#666666',
    },

    eventList: {
        gap: 10,
    },
    eventItem: {
        backgroundColor: '#f5f5f5',
        padding: 15,
        borderRadius: 8,
    },
    eventItemTitle: {
        fontSize: 16,
        fontWeight: '600',
        color: '#000000',
        marginBottom: 6,
    },
    eventItemMeta: {
        fontSize: 13,
        color: '#666666',
    },
    eventItemNotes: {
        marginTop: 8,
        fontSize: 13,
        color: '#666666',
    },

    modalOverlay: {
        flex: 1,
        justifyContent: 'center',
        padding: 20,
    },
    modalBackdrop: {
        ...StyleSheet.absoluteFillObject,
        backgroundColor: '#000000',
        opacity: 0.5,
    },
    modalCard: {
        backgroundColor: '#ffffff',
        borderRadius: 12,
        padding: 16,
    },
    modalCardDark: {
        backgroundColor: '#1a1a1a',
    },
    modalTitle: {
        fontSize: 18,
        fontWeight: '700',
        color: '#000000',
        marginBottom: 6,
    },
    modalSubtitle: {
        fontSize: 13,
        color: '#666666',
        marginBottom: 12,
    },
    input: {
        borderWidth: 1,
        borderColor: '#d9e1e8',
        borderRadius: 8,
        paddingHorizontal: 12,
        paddingVertical: 10,
        fontSize: 14,
        color: '#000000',
        backgroundColor: '#ffffff',
        marginBottom: 10,
    },
    inputDark: {
        borderColor: '#444444',
        color: '#ffffff',
        backgroundColor: '#1a1a1a',
    },
    timeRow: {
        flexDirection: 'row',
        gap: 10,
    },
    timeInput: {
        flex: 1,
    },
    notesInput: {
        minHeight: 80,
        textAlignVertical: 'top',
    },
    formErrorText: {
        color: '#2196F3',
        marginBottom: 10,
        fontSize: 13,
    },
    modalActions: {
        flexDirection: 'row',
        justifyContent: 'flex-end',
        gap: 10,
        marginTop: 4,
    },
    actionButton: {
        paddingHorizontal: 14,
        paddingVertical: 10,
        borderRadius: 8,
    },
    cancelButton: {
        backgroundColor: '#f5f5f5',
    },
    cancelButtonText: {
        color: '#2d4150',
        fontWeight: '600',
        fontSize: 14,
    },
    saveButton: {
        backgroundColor: '#2196F3',
    },
    saveButtonText: {
        color: '#ffffff',
        fontWeight: '700',
        fontSize: 14,
    },
});

export default HomeScreen;
