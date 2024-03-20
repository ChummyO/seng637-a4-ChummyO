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


