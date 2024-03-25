## Analysis of 10 mutants of the Range class

1. #### Mutation #1 (on line #157, mutation #1)

   Mutation applied by Pitest was `changed conditional boundary → SURVIVED` on the method `intersects(double b0, double b1)`. This mutation was applied to the below line of code

   ```
   if (b0 <= this.lower);
   ```

   This mutation changed the conditional boundary to < according to the PIT documentation [PIT doc](https://pitest.org/quickstart/mutators/). The mutant survived because there was no test case where the range was not completely outside the lower and upper bound range. Test case had to be commented out because it was causing a failure and mutation needs a green junit test

2. #### Mutation #2 (on line #161, mutation #29)

   Mutation applied by Pitest was `Less than to less or equal → SURVIVED` on the method `intersects(double b0, double b1)`. This mutation was applied to the below line of code

   ```
   return (b0 < this.upper && b1 >= b0);
   ```

   Since the else statement is returning false, b0 < this.upper should be false to make that line false. replaing < with <= acts as an equivalent mutant because it does the same thing as the original code to return false since b0 should not be less than or equal to this.upper

3. #### Mutation #3 (on line #161, mutation #35)

   Mutation applied by Pitest was `Less than to equal → SURVIVED` on the method `intersects(double b0, double b1)`. This mutation was applied to the below line of code

   ```
   return (b0 < this.upper && b1 >= b0);
   ```

   Since the else statement is returning false, b0 < this.upper should be false to make that line false. replaing < with == acts as an equivalent mutant because it does the same thing as the original code to return false since b0 should not be equal to this.upper

4. #### Mutation #4 (on line #161, mutation #32)

   Mutation applied by Pitest was `greater or equal to greater than → SURVIVED` on the method `intersects(double b0, double b1)`. This mutation was applied to the below line of code

   ```
   return (b0 < this.upper && b1 >= b0);
   ```

   Since the else statement is returning false, b0 < this.upper should be false to make that line false since b1 >= b0 will be true. replaing >= with > acts as an equivalent mutant because it does the same thing as the original code to make the second line true. The range will always have b1 >= b0 to be a valid range

5. #### Mutation #5 (on line #448, mutation #36)

   Mutation applied by Pitest was `Incremented (a++) double field lower → SURVIVED` on the method `isNaNRange()`. This mutation was applied to the below line of code

   ```
   return Double.isNaN(this.lower) && Double.isNaN(this.upper);
   ```

   Since the mutant is increasing this.lower by 1, NaN + 1 is still NaN so the mutant does the same thing as the code, hence it survives. If this.lower is an actual number, increasing it doesn't make a difference because it will still be an actual number and Double.isNaN(this.lower) will be false.

6. #### Mutation #6 (on line #448, mutation #37)

   Mutation applied by Pitest was `Incremented (a++) double field upper → SURVIVED` on the method `isNaNRange()`. This mutation was applied to the below line of code

   ```
   return Double.isNaN(this.lower) && Double.isNaN(this.upper);
   ```

   Since the mutant is increasing this.upper by 1, NaN + 1 is still NaN so the mutant does the same thing as the code, hence it survives. If this.upper is an actual number, increasing it doesn't make a difference because it will still be an actual number and Double.isNaN(this.upper) will be false.

7. #### Mutation #7 (on line #448, mutation #38)

   Mutation applied by Pitest was `Decremented (a--) double field lower → SURVIVED` on the method `isNaNRange()`. This mutation was applied to the below line of code

   ```
   return Double.isNaN(this.lower) && Double.isNaN(this.upper);
   ```

   Since the mutant is decreasing this.lower by 1, NaN - 1 is still NaN so the mutant does the same thing as the code, hence it survives. If this.lower is an actual number, decreasing it doesn't make a difference because it will still be an actual number and Double.isNaN(this.lower) will be false.

8. #### Mutation #8 (on line #448, mutation #39)

   Mutation applied by Pitest was `Decremented (a--) double field upper → SURVIVED` on the method `isNaNRange()`. This mutation was applied to the below line of code

   ```
   return Double.isNaN(this.lower) && Double.isNaN(this.upper);
   ```

   Since the mutant is decreasing this.upper by 1, NaN - 1 is still NaN so the mutant does the same thing as the code, hence it survives. If this.upper is an actual number, decreasing it doesn't make a difference because it will still be an actual number and Double.isNaN(this.upper) will be false.

9. #### Mutation #9 (on line #308, mutation #1)

   Mutation applied by Pitest was `changed conditional boundary → SURVIVED` on the method `expandToInclude(Range range, double value)`. This mutation was applied to the below line of code

   ```
   else if (value > range.getUpperBound());
   ```

   This mutation changed the conditional boundary to >= according to the PIT documentation [PIT doc](https://pitest.org/quickstart/mutators/). The mutant survived because it is an equivalent mutant which does the same thing as the original code because when value is equal to upperbound, it returns the range.

10. #### Mutation #10 (on line #306, mutation #7)

    Mutation applied by Pitest was `Decremented (a--) double local variable number 1 → SURVIVED` on the method `expandToInclude(Range range, double value)`. This mutation was applied to the below line of code

    ```
    return new Range(value, range.getUpperBound());
    ```

    This mutation decreases value by 1 which still includes value itself causing the mutant to survive.

## Mutation score and statistics

After commenting out failing test cases in Assignment 3, we ran mutation tests on `Range` and `DataUtilities`. Then we added new test cases to increase the mutation score.

- **Mutation score of Range - before**

  ![Range_Mutants_Score_Before](Range_PIT_screenshot_before.png)

- **Mutation statistics of Range - before**

  ![Range_Mutants_Statistics_Before](mutation_stat_range_before.png)

  Due to the the Range class containing other methods that are not tested, the overall score is not a very accurate measure of the coverage. Below is the coverage of each method calculated manually.

  | Method                                   | Survived | Killed | Total | Coverage % |
  | ---------------------------------------- | -------- | ------ | ----- | ---------- |
  | `Range.isNaNRange()`                     | 18       | 25     | 43    | 58.14      |
  | `Range.intersects(double, double)`       | 27       | 77     | 104   | 74.03      |
  | `Range.expandToInclude(Range, double)`   | 10       | 57     | 67    | 85.07      |
  | `Range.combineIgnoringNaN(Range, Range)` | 18       | 67     | 85    | 78.82      |
  | `Range.combine(range1, range2)`          | 4        | 29     | 33    | 87.88      |
  | `Range.contains(double value)`           | 8        | 45     | 53    | 84.90      |
  | Total                                    | 85       | 300    | 385   | 77.92      |

- **Mutation score of Range - after**

  ![Range_Mutants_Score_After](Range_PIT_screenshot_after.png)

- **Mutation statistics of Range - after**

  ![Range_Mutants_Statistics_After](mutation_stat_range_after.png)

  Below is the coverage of each method calculated manually for the Range class after adding test cases. As we could not improve scores significantly test cases for two additional methods were also created.

  | Method                                   | Survived | Killed | Total | Coverage % |
  | ---------------------------------------- | -------- | ------ | ----- | ---------- |
  | `Range.isNaNRange()`                     | 18       | 25     | 43    | 58.14      |
  | `Range.intersects(double, double)`       | 27       | 77     | 104   | 74.03      |
  | `Range.expandToInclude(Range, double)`   | 10       | 57     | 67    | 85.07      |
  | `Range.combineIgnoringNaN(Range, Range)` | 18       | 67     | 85    | 78.82      |
  | `Range.combine(range1, range2)`          | 4        | 29     | 33    | 87.88      |
  | `Range.contains(double value)`           | 8        | 45     | 53    | 84.90      |
  | Total for original methods               | 85       | 300    | 385   | 77.92      |
  | -                                        | -        | -      | -     | -          |
  | `Range.toString()`                       | 4        | 18     | 22    | 81.82      |
  | `Range.equals(Object obj)`               | 7        | 66     | 73    | 90.41      |
  | `Range.scale(Range base, double factor)` | 6        | 44     | 50    | 88         |
  | `Range.getCentralValue()`                | 4        | 43     | 47    | 91.49      |
  | `Range.getLength()`                      | 4        | 15     | 19    | 78.95      |
  | Total including new methods              | 110      | 486    | 596   | 81.54      |

- **Mutation score of DataUtilities - before**

  ![Range_Mutants_Score_Before](PIT_Coverage_Score_Before.png)

- **Mutation statistics of DataUtilities - before**

  ![Range_Mutants_Statistics_Before](PIT_Coverage_Stats_Before.png)

- **Mutation score of DataUtilities - after**

  ![Range_Mutants_Score_After](PIT_Coverage_Score_After.png)

- **Mutation statistics of DataUtilities - after**

  ![Range_Mutants_Statistics_After](mutation_stat_range_after.png)

## Analysis on effectiveness of each of the test classes

Our test suite developed for Range and DataUtilities classes were sufficient to test the boundary conditions

When we analysed the PIT report, we found out that most mutants were either stubborn mutants or equivalent mutants. Therefore, there was nothing much to do. We added some more test cases for additional methods which improved the mutation score form 41% to 53%, meeting the requirement of at least an increase of 10%

## Effect of Equivalent Mutants on Mutation Score Accuracy

Equivalent mutants, which are mutations of the program that do not change its external behavior, pose a significant challenge to the accuracy of mutation scores. Since these mutants cannot be killed by any test case, their presence can skew the mutation score, making it appear lower than it actually is in terms of test effectiveness.

### Detecting Equivalent Mutants

Detecting equivalent mutants is complex but can be approached through:

1. **Static Analysis:** Analyzing the code to identify mutations that do not alter the program's logic or flow.
2. **Dynamic Analysis:** Running test suites to see if the mutant and the original program always produce the same output for all test cases.
3. **Manual Review:** In some cases, developers might need to manually inspect the mutant and the original code to determine equivalence.
4. **Using Concolic Testing:** Combining symbolic and concrete execution to explore different execution paths and identify if a mutant truly behaves identically under all possible inputs.

### Proposed Method for Automatic Detection

A potential approach to automatically detect equivalent mutants involves a combination of static and dynamic analysis techniques:

1. **Semantic Analysis:** Employ semantic analysis tools to compare the abstract syntax trees (ASTs) of the original and mutated code. Changes that do not affect the AST's semantics could indicate an equivalent mutant.
2. **Coverage Analysis:** Execute both the original and mutated code with the full test suite, comparing the coverage results. Equivalent mutants may exhibit identical coverage patterns.
3. **Differential Testing:** Use differential testing to execute both versions of the code with a large set of inputs, comparing outputs. Identical outputs across all inputs suggest equivalence.
4. **Machine Learning Models:** Train machine learning models on known equivalent and non-equivalent mutants to predict the likelihood of a new mutant being equivalent based on code change patterns.

### Discussion

Equivalent mutants can negatively impact the perceived quality of a test suite by artificially lowering the mutation score. Accurately detecting and excluding equivalent mutants from the mutation score calculation can provide a more accurate measure of how well the test suite can detect real faults in the code.

However, detecting equivalent mutants automatically is inherently difficult and often requires significant computational resources and sophisticated analysis techniques. While the proposed method combines several approaches to improve detection accuracy, it also highlights the complexity and challenges involved in accurately identifying equivalent mutants in mutation testing.

## What could have been done to improve the mutation score of the test suites

To improve mutation score, new test cases can be designed or test cases can be added to the existing test suites to address areas with inadequate coverage

## Improving Mutation Score in Range.java

For Range class, additional test cases were added for more methods because the initial test cases appeared sufficient for the methods originally covered. The new methods covered were:
toString, Scale, Equals, getCentralValue and getLength as seen in RangeTest.java

## Improving Mutation Score in DataUtilities.java

To increase the mutation score and line coverage for `DataUtilities.java`, we strategically designed and implemented test cases addressing specific areas where the initial test suite was lacking. The primary goal was to kill mutants that survived initial test runs, uncovering weaknesses in the test suite's ability to validate the code under test's correctness and robustness. Below is a discussion on the rationale behind each set of test cases and their contribution to improving the mutation score.

### Handling Negative and Large Values

- **Tests for Negative and Large Values**: Designed to ensure methods under test could handle edge cases involving negative numbers and large values. This is crucial for calculation methods, as such values can often lead to unexpected results or overflow errors.

### Ensuring Equality Checks Are Comprehensive

- **Tests for `equal` Method Variations**: Aimed at ensuring data comparisons are reliable by covering scenarios including arrays of different lengths, arrays containing `null`, and arrays with the same lengths but different values.

### Verifying Correct Number Conversions

- **Tests for `createNumberArray` and `createNumberArray2D`**: Focus on verifying accurate conversions across a range of values, including `NaN`, `Infinity`, and zero-length arrays, ensuring accurate representation when transformed into `Number` objects.

### Validating Cumulative Percentages Calculation

- **Tests for `getCumulativePercentages` with Special Cases**: Verify accurate calculation of cumulative percentages, especially when dealing with datasets that include zero totals or a mix of positive and negative values.

### Addressing Floating-Point Precision

- **Precision Test for Floating-Point Calculations**: Ensures calculations within `DataUtilities` do not suffer from precision errors, which is vital for operations like `calculateRowTotal` and `calculateColumnTotal`.

### Testing with Extreme Values

- **Handling Extreme Values**: Tests added to ensure methods correctly handle extremely large values without causing overflow and that methods returning arrays handle zero-length inputs correctly.

### Deep Cloning Verification

- **Ensuring Deep Clone**: Verifies that the `clone` method creates a deep copy of the array, ensuring data integrity when arrays are passed between methods or components.

### Design Philosophy

The tests were guided by principles of boundary value testing, equivalence partitioning, and error guessing, targeting edge cases, special values, and potential error conditions to expose hidden bugs and ensure resilience against a wide array of inputs and scenarios. The ultimate goal was to enhance the mutation score, indicating a higher quality and more robust test suite capable of comprehensively asserting the correctness of `DataUtilities.java`.

## Why We Need Mutation Testing

Mutation testing helps evaluate the quality of software tests by introducing small changes, or "mutants", to the program's source code and checking if the current tests can detect these changes. It's a way to measure how well the test suite can catch errors and thus serves as a metric for the test's effectiveness.

### Advantages of Mutation Testing

1. **Improves Test Quality:** By identifying specific weaknesses in the test suite, it encourages the development of more comprehensive tests.
2. **Detects Code Undercoverage:** Helps in finding code that is not adequately tested, guiding developers to areas that need more testing attention.
3. **Encourages Effective Testing:** Promotes the creation of effective and efficient test cases rather than aiming for high coverage with potentially shallow tests.
4. **Identifies Redundant Code:** Can reveal dead or redundant code paths that are not contributing to the software's functionality.
5. **Facilitates Refactoring:** Knowing that the test suite is robust allows developers to refactor with confidence, ensuring that changes do not introduce new bugs.

### Disadvantages of Mutation Testing

1. **Performance and Scalability:** Mutation testing can be computationally expensive and slow, especially for large codebases, due to the need to generate and test many mutants.
2. **Equivalent Mutants:** Identifying and dealing with equivalent mutants (mutations that do not alter the program's external behavior) can be challenging and time-consuming.
3. **Interpretation of Results:** The effectiveness of mutation testing depends on the quality of the mutations generated. Poorly chosen mutations might not lead to meaningful insights.
4. **Resource Intensive:** Requires significant computational resources to execute all mutants against the test suite, which can be a barrier for continuous integration environments.
5. **Complexity in Setup and Use:** Setting up a mutation testing framework and interpreting its results can be complex, potentially requiring considerable effort to integrate into existing development workflows.

Despite these disadvantages, mutation testing remains a powerful tool for improving test suite effectiveness, leading to more robust and reliable software.

## Difficulties, challenges, and lessons learned

One of our team members encountered an error while trying to run PIT test. The error was **"Exception in thread "main" java.lang.IllegalArgumentException: Unsupported class file major version 63**. After a lot of research, trial and error, the error was solved by downgrading the JRE System Library to JavaSE-1.6 .
