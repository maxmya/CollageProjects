parent(pan,bob).
parent(tom,bob).
parent(tom,mona).
parent(bob,ann).
parent(bob,pat).
parent(pat,jin).


male(jin).
male(tom).
male(bob).
female(mona).
female(pan).
female(ann).
female(pat).


offspring(X,Y):-
    parent(X,Y).

mother(X,Y):-
    parent(X,Y),female(X).

grandparent(X,Z):-
    parent(X,Y),parent(Y,Z).

sister(X,Y):-
    parent(Z,X),parent(Z,Y),female(X),X\=Y.

predeceassor(X,Z):-
    parent(X,Z).

predeceassor(X,Z):-
    parent(X,_),predeceassor(X,Z).
