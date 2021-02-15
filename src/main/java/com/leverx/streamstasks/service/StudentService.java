package com.leverx.streamstasks.service;

import com.leverx.streamstasks.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static com.leverx.streamstasks.util.StudentConstants.Names.DAVE;
import static com.leverx.streamstasks.util.StudentConstants.Names.MIKE;
import static com.leverx.streamstasks.util.StudentConstants.Names.STEVE;
import static com.leverx.streamstasks.util.StudentConstants.Subjects;
import static com.leverx.streamstasks.util.StudentConstants.Subjects.CHEMISTRY;
import static com.leverx.streamstasks.util.StudentConstants.Subjects.MATH;
import static com.leverx.streamstasks.util.StudentConstants.Subjects.PE;
import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

/**
 * @author Tsimafei Shostka
 */
@Service
public class StudentService {

    public Map<String, Double> calculateSubjectRatingAverage1() {
        return stream(Subjects.values())
                .map(Subjects::getValue)
                .collect(toMap(identity(), this::calculateSubjectRatingAverage1));
    }

    public Map<String, Double> calculateSubjectRatingAverage2() {
        return stream(Subjects.values())
                .map(Subjects::getValue)
                .collect(toMap(identity(), this::calculateSubjectRatingAverage2));
    }

    private double calculateSubjectRatingAverage1(String subject) {
        return generateStudents().stream()
                .mapToDouble(student -> student.getRating().getOrDefault(subject, 0))
                .average().orElse(0);
    }

    private double calculateSubjectRatingAverage2(String subject) {
        return generateStudents().stream()
                .filter(student -> student.hasSubject(subject))
                .mapToDouble(student -> student.getRating().get(subject))
                .average().orElse(0);
    }

    private List<Student> generateStudents() {

        Student dave = new Student(DAVE)
                .rate(MATH.getValue(), 10)
                .rate(CHEMISTRY.getValue(), 7);

        Student steve = new Student(STEVE)
                .rate(CHEMISTRY.getValue(), 10)
                .rate(PE.getValue(), 7);

        Student mike = new Student(MIKE)
                .rate(PE.getValue(), 10)
                .rate(MATH.getValue(), 7);

        return List.of(dave, steve, mike);
    }

    public Map<String, String> getRatingOfSubjectsForStudents() {
        return generateStudents().stream()
                .map(Student::getRating)
                .map(Map::keySet)
                .reduce(new HashSet<>(), (accumulator, subjectSet) -> {
                    accumulator.addAll(subjectSet);
                    return accumulator;
                }).stream().collect(toMap(identity(), subject -> generateStudents().stream()
                        .filter(student -> student.hasSubject(subject))
                        .map(student -> student.getName() + ":" + student.getRating().get(subject))
                        .collect(joining(", ", "(", ")"))));
    }
}
