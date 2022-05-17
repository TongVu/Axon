package com.axonactive.programmingChallenges.CourseGrades;

import com.axonactive.programmingChallenges.CourseGrades.GradedActivity;

interface Analyzable {
    double getAverage();
    GradedActivity getHighest();
    GradedActivity getLowest();
}
