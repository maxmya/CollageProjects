from sklearn.datasets import fetch_20newsgroups
from sklearn.naive_bayes import MultinomialNB

import numpy as np

total_data_file = open("total-notations.txt")

text = []
prn = []

for i in total_data_file :
        prn.append(i.strip()[-1])
        text.append(i[:-1])
        
import logging
logging.basicConfig()


twenty_train = fetch_20newsgroups(subset='train',
        categories=text, shuffle=False ) 




#model = MultinomialNB()
#model.fit(text, prn)


#predicted= model.predict("it was a nice day")
#print predicted


