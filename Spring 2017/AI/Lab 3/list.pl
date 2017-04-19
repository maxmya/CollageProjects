first([Y|_],X):-X = Y.

last(X,[X]).

last(Y,[_|L]):- last(Y,L).



count(0,[]).
count(X,[_|L]):-count(M,L),X is M +1.

member(X,[X|_]).
member(X,[_|L]):-member(X,L).


append([A,B],[],L):-L is [A,B].
append([],[A,B],L):-L is [A,B].

append([A,B],[C,D],L):-L is [A,B]+[C,D].
