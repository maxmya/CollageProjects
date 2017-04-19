edge(a,b).
edge(a,c).
edge(b,d).
edge(d,e).
edge(c,d).
edge(c,f).
edge(f,a).

path(X,Y):-
  edge(X,Y).

 path(X,Y):-
    edge(X,Z),path(Z,Y).



    paths(X,X,[X]).
    paths(X,Y,[X,Y]):-edge(X,Y).
    paths(X,Y,List):-edge(X,Z),paths(Z,Y,L),append([X,Z],L,List).
