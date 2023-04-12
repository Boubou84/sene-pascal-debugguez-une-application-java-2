STAGE2=.guides/stage2.txt
STAGE3=.guides/stage3.txt
STAGE4=.guides/stage4.txt
if [ -f "$STAGE2" ]; then
  STATUS=$(cat .guides/stage2.txt)
  echo "Stage 2"
  if [ $STATUS == "STAGE_2_PASSED=1" ]; then 
    echo "Student has deleted all the extra comments"
  else
    echo "Student did not complete the remove comments task"
  fi 
else
  echo "Student did not complete the remove comments task"
fi

if [ -f "$STAGE3" ]; then
  STATUS=$(cat .guides/stage3.txt)
  echo "Stage 3"
  if [ $STATUS == "STAGE_3_PASSED=4" ]; then 

    echo "Student has passed all the unit tests in Stage 3"
  else
    echo "Student did not pass all the unit tests in Stage 3"
    echo $STATUS
  fi 
else
    echo "Student did not run the tests in Stage 3"
fi

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

if [ -f "$STAGE5" ]; then
  STATUS=$(cat .guides/stage5.txt)
  echo "Stage 5"
    if [ $STATUS == "STAGE_5_PASSED=1" ]; then 
    echo "Student has passed all the tests in Stage 5"
  else
    echo "Student did not pass all the tests in Stage 5"
    echo $STATUS
  fi 
else
  echo "Student did not run the tests in Stage 5"
fi

echo "Here are the branches the student has created"
git branch -a

echo "Here is all the commit information"
git log