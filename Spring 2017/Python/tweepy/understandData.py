import json
import csv
import collections as c


tweets_data = []
tweets_file = open('dataFile.txt', "r")
for line in tweets_file:
    try:
        tweet = json.loads(line)
        tweets_data.append(tweet)
    except:
        continue



all_tweets = []
all_hashtags = []
all_locations = []
all_users = []
all_times = []


for i in tweets_data:
        all_tweets.append(i['text'])


for i in tweets_data:
    for hashtag in i['entities']['hashtags']:
            all_hashtags.append(hashtag['text'])


for i in tweets_data:
    all_locations.append(i['place']['country'])


for i in tweets_data:
    all_times.append(i['created_at'])

for i in tweets_data:
    for user in i['entities']['user_mentions']:
            all_users.append(user['name'])



print 'Tweets :'
for i in all_tweets:
    print i.encode('utf-8')

print 'Locations :'
for i in all_locations:
    print i.encode('utf-8')


print 'Mentions :'
for i in all_users:
    print i.encode('utf-8')

print 'Times :'
for i in all_times:
    print i.encode('utf-8')

print 'Hashtags :'
for i in all_hashtags:
    print i.encode('utf-8')

print 'Most Repeated country'
l = c.Counter(all_locations)
print l.most_common()[0]
print l

print 'Most Repeated Hashtag'
h = c.Counter(all_hashtags)
print h.most_common()[0]
print h
print len(h)


print 'Most Repeated Mentions'
m = c.Counter(all_users)

print m.most_common()[0][0].encode('utf-8')
for i in m:
    print i.encode('utf-8')
print m 
