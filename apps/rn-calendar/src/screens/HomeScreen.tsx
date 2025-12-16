import React, { useState } from 'react';
import {
    SafeAreaView,
    ScrollView,
    StyleSheet,
    Text,
    View,
    TouchableOpacity,
    useColorScheme,
} from 'react-native';
import { Calendar } from 'react-native-calendars';

const HomeScreen = () => {
    const isDarkMode = useColorScheme() === 'dark';
    const [selectedDate, setSelectedDate] = useState('');

    const onDayPress = (day: any) => {
        setSelectedDate(day.dateString);
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
                    markedDates={{
                        [selectedDate]: {
                            selected: true,
                            selectedColor: '#2196F3',
                        },
                    }}
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
                        <Text style={[styles.eventTitle, isDarkMode && styles.textDark]}>
                            {selectedDate} 的日程
                        </Text>
                        <View style={styles.eventCard}>
                            <Text style={[styles.eventText, isDarkMode && styles.textDark]}>
                                暂无日程
                            </Text>
                        </View>
                    </View>
                ) : null}
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
    eventTitle: {
        fontSize: 18,
        fontWeight: 'bold',
        marginBottom: 10,
        color: '#000000',
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
});

export default HomeScreen;
