f = open("tweetManual_atef.txt")

print "".join(line for line in f if not line.isspace())

