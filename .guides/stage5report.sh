STAGE5=.guides/stage5.txt
if [ -f "$STAGE5" ]; then
  STATUS=$(cat .guides/stage5.txt)
  echo "Stage 5"
    if [ $STATUS == "STAGE_5_PASSED=1" ]; then 
    echo "The code compiles, runs and outputs the correct result.out"
  else
    echo "Student did not pass all the tests in Stage 5"
    echo $STATUS
  fi 
else
  echo "Student did not run the tests in Stage 5"
fi