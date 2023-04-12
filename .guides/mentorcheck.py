import os, re, io, sys

fail = 0

# read Code file
with open('com/hemebiotech/analytics/AnalyticsCounter.java') as response:
  answer = response.read()

# check that they are creating a Map
if re.search('Map<String, *Integer>',answer):
  print("Student code is using a map to store the information")
else:
  fail = 1
  print("Student code is not using a map to store the information")


# check that they are traversing the map properly
if re.search('for *\(String +[A-Za-z]+ *: *[A-Za-z]+\)',answer):
  print("Student code is traversing the map properly")
else:
  fail = 1
  print("Student code is not traversing the map properly")
