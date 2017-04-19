import csv
import collections

num_of_CLAY_COUNTY = 0
countries = []
tiv_2012 = []
with open('file.csv', 'rU') as myFile:
    my_file_reader = csv.reader(myFile, delimiter=',')
    elements_list = []
    for row in my_file_reader:
        if len(row) != 0:
            elements_list += [row]
            countries.append(row[2])
            if row[2] == "CLAY COUNTY":
                num_of_CLAY_COUNTY += 1
            if row[2] == "COLUMBIA COUNTY":
                tiv_2012.append(row[8])
myFile.close()
m_counter = collections.Counter(countries)
print "Number of Records is : ", len(elements_list)
print "Number of Columns is : ", len(elements_list[0]), "\nNames of Columns Are : ", elements_list[0]
print "Number of (CLAY COUNTY) is : ", num_of_CLAY_COUNTY
print "The highest country has policies is ", m_counter.most_common()[0]
k = 0
unique = []
keys = list(m_counter.keys())
values = list(m_counter.values())
for index in values:
    k += 1
    if index == 1:
        unique.append(keys[k - 1])
print "The lowest country has policies is ", len(unique), " and they are ", unique
print "Num of Unique Countries (all countries without redundancy)", len(keys)
print "Names of Countries Without Redundancy ", m_counter.keys()
tiv_2012 = [float(z) for z in tiv_2012]
print "Average value for (tiv_2012) column for country (COLUMBIA COUNTY)", sum(tiv_2012) / len(tiv_2012)
