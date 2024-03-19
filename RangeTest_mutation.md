## Analysis of 10 mutants of the Range class

1. #### Mutation #1 (on line #157, mutation #1)

   Mutation applied by Pitest was `changed conditional boundary → SURVIVED` on the method `intersects(double b0, double b1)`. This mutation was applied to the below line of code

   ```
   if (b0 <= this.lower);
   ```

   This mutation changed the conditional boundary to < according to the PIT documentation [PIT doc](https://pitest.org/quickstart/mutators/). 
