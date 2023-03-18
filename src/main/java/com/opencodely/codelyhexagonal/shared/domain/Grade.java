package com.opencodely.codelyhexagonal.shared.domain;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Getter
public enum Grade {
    GRADE_III("III", 0),
    GRADE_IV("IV", 1),
    GRADE_V("V", 2),
    GRADE_6A("6a", 3),
    GRADE_6B("6b", 4),
    GRADE_6C("6c", 5);
    private final String name;
    private final int value;
    @Getter(AccessLevel.NONE)
    private static final Map<Integer, Grade> VALUE_GRADE_MAP = new HashMap<>();

    static {
        for (Grade grade : Grade.values()) {
            VALUE_GRADE_MAP.put(grade.value, grade);
        }
    }

    Grade(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static Grade averageGrade(Collection<Grade> grades) {
        int addedValue = grades.stream().map(Grade::getValue).reduce(0, Integer::sum);
        int average = addedValue / grades.size();
        return fromValue(average);
    }

    public static Grade fromValue(int value) {
        if (!VALUE_GRADE_MAP.containsKey(value)) {
            throw new IllegalArgumentException(String.format("No grade matches %d value", value));
        }
        return VALUE_GRADE_MAP.get(value);
    }

    @Override
    public String toString() {
        return "Grade{" + "name='" + name + '\'' + '}';
    }
}
