import bs4
from urllib import urlopen as uReq
from bs4 import BeautifulSoup as soup

my_url = 'https://techcrunch.com/enterprise/'
my_Con = uReq(my_url)
page_Html = my_Con.read()
my_Con.close()
page_soup = soup(page_Html, "html.parser")

parsers = page_soup.find_all("a")

result = []

for i in parsers:
    result.append(i.get("href"))

for el in result:
    try:
        if "https://techcrunch.com/2017/" in el:
            connection = uReq(el)
            reader = connection.read()
            connection.close()
            pages = soup(reader,"html.parser")
            articals = pages.find_all("p")
            len(articals)
            print articals
    except:
        print "error"
        pass
