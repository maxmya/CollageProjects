
import json




f = open("twitter.txt","r")


for i in f:
    if '{' in i :
      print json.loads(i)["text"].encode('utf-8')
