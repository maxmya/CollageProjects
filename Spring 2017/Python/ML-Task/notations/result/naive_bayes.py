from sklearn.naive_bayes import MultinomialNB
from sklearn.feature_extraction.text import CountVectorizer
import numpy as np



total_data_file = open("total-notations.txt")

text = []
prn = []



for i in total_data_file :
    if  '1' in (i.strip()[-1]) or  '0' in (i.strip()[-1]):
        prn.append(i.strip()[-1])
        text.append(i.strip()[:-2])



# #80% model for train 
train_txt = text[:1530]
train_prn = prn[:1530]

# #20% model for test 
test_txt = text[1530:]
test_prn = prn[1530:]




count_vect = CountVectorizer()
X_train_counts = count_vect.fit_transform(train_txt)
X_train_counts.shape

my_classifier = MultinomialNB().fit(X_train_counts,train_prn)


X_test_counts = count_vect.transform(test_txt)
X_test_counts.shape 
predicted = my_classifier.predict(X_test_counts)



error = 0 
for i in range(382):
    if predicted[i]!=test_prn[i]:
        error = error+1

print "The naive-bayes algorithm have learned your data"
print ((error/382)*100) , "% error rate"


while True:
    print "Enter an English Statment (press ctrl z to end )"
    my_string = raw_input() 
    X = count_vect.transform([my_string])
    X.shape
    predection = my_classifier.predict(X)
    if '1' in predection[0]:
        print "your statment is positive"
    elif '0' in predection[0]:
        print "your statment is negative"
