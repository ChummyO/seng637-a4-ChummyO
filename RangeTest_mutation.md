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

**Note**: All the 4 tables below includes equivalent mutations in coverage calculations in order to be consistent with the Pitest scores.

- **Mutation score of Range - before**

  ![Range_Mutants_Score_Before](images/Range_Mutant_Score_Before.png)

- **Mutation statistics of Range - before**

  ![Range_Mutants_Statistics_Before](images/Range_Mutant_Statistics_Before.png)

  Due to the the Range class containing other methods that are not tested, the overall score is not a very accurate measure of the coverage. Below is the coverage of each method calculated manually.

  | Method                                   | Survived | Killed | Total | Coverage % |
  | ---------------------------------------- | -------- | ------ | ----- | ---------- |
  | `Range.isNaNRange()`                     | 10       | 33     | 43    | 76.74      |
  | `Range.shift(Range, double, boolean)`    | 9        | 53     | 62    | 85.48      |
  | `Range.intersects(double, double)`       | 23       | 83     | 106   | 78.30      |
  | `Range.expandToInclude(Range, double)`   | 10       | 57     | 67    | 85.07      |
  | `Range.combineIgnoringNaN(Range, Range)` | 18       | 68     | 86    | 79.07      |
  | Total                                    | 70       | 294    | 364   | 80.77      |

- **Mutation score of Range - after**

  ![Range_Mutants_Score_After](images/Range_Mutant_Score_After.png)

- **Mutation statistics of Range - after**

  ![Range_Mutants_Statistics_After](images/Range_Mutant_Statistics_After.png)

  Below is the coverage of each method calculated manually for the Range class after adding test cases. As we could not improve scores significantly test cases for two additional methods were also created.

  | Method                                   | Survived | Killed | Total | Coverage % |
  | ---------------------------------------- | -------- | ------ | ----- | ---------- |
  | `Range.isNaNRange()`                     | 10       | 33     | 43    | 76.74      |
  | `Range.shift(Range, double, boolean)`    | 8        | 54     | 62    | 87.10      |
  | `Range.intersects(double, double)`       | 17       | 89     | 106   | 83.96      |
  | `Range.expandToInclude(Range, double)`   | 10       | 57     | 67    | 85.07      |
  | `Range.combineIgnoringNaN(Range, Range)` | 10       | 76     | 86    | 88.72      |
  | Total for original methods               | 55       | 309    | 364   | 84.89      |
  | -                                        | -        | -      | -     | -          |
  | `Range.combine(Range, Range)`            | 4        | 29     | 33    | 87.87      |
  | `Range.expand(Range, Range)`             | 16       | 118    | 134   | 88.60      |
  | Total including new methods              | 75       | 456    | 531   | 85.87      |

## Analysis on effectiveness of each of the test classes

Our test suite developed for Range and DataUtilities classes were sufficient to test the boundary conditions

When we analysed the PIT report, we found out that most mutants were either stubborn mutants or equivalent mutants. Therefore, there was nothing much to do. We added some more test cases for additional methods which improved the mutation score by  
