STAGE4=.guides/stage4.txt

if [ -f "$STAGE4" ]; then
  STATUS=$(cat .guides/stage4.txt)
  echo "Stage 4"
  if [ $STATUS == "STAGE_4_PASSED=4" ]; then 
    echo "Student has passed all the unit tests in Stage 4"
  else
    echo "Student did not pass all the unit tests in Stage 4"
    echo $STATUS
  fi 
else
  echo "Student did not run the tests in Stage 4"
fi