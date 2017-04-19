import tweepy
import json

#  keys , tokens and shit
consumer_key = 'ovhTSbmojVOACMFabE0KafIjC'
consumer_secret = 'FbgmqqlYsOaw063AGSWO2le1qXsI38BXhuJXgXA5COtz6U081A'
access_token = '2227210118-2wtc4W3TrefF8H2valbmZ11RodM958WPNTXiu4Y'
access_token_secret = 'qZ5zmCLpmY6JvqEq0oEJuip254lZucegBQMsV7IBJkj7R'

# auth object creation
auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_token_secret)

# api connection with authorization
api = tweepy.API(auth)

# read & print stream from home_timeline
    # public_tweets = api.home_timeline()
    # for tweet in public_tweets:
    #     print tweet.text.encode('utf-8')

# class for custom stream class extends StreamListener from tweepy
class MyStreamListener(tweepy.StreamListener):

    def on_status(self, status):
        print json.dumps(status._json)
        return True

    def on_error(self, status):
        print 'Error'+status




#init stream 3ala Egypt
myStreamListener = MyStreamListener()
myStream = tweepy.Stream(auth = api.auth, listener=myStreamListener)
# geobox for egypt !
myStream.filter(locations=[25.13671875, 22.0245456012, 35.3759765625, 31.3723991049],async=True)
