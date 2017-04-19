edge(a,b).
edge(f,c).
edge(b,f).

path(A,Z):-
    edge(A,Z).

path(A,Z):-
    edge(A,Y),path(Y,Z).
