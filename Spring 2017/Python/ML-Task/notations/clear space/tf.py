from sklearn import naive_bayes 
import numpy as np



total_data_file = open("total-notations.txt")

text = []
prn = []


for i in total_data_file :
    if  '1' in (i.strip()[-1]) or  '0' in (i.strip()[-1]):
        prn.append(i.strip()[-1])
        text.append(i[:-1])

print text


# text = np.array(text).reshape(-1,1)

# [float(i) for i in prn]


# clf = naive_bayes.GaussianNB()
# clf = clf.fit(text,prn)


#print clf.predict("this is a nice day")