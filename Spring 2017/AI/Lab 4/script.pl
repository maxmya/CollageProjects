edge(a,b).
edge(a,c).
edge(b,d).
edge(d,e).
edge(d,c).
edge(c,f).
edge(f,a).

path(X,Y,Z):-
  edge(X,Y),Z is [X,Y].

 path(X,Y,A):-
    edge(X,Z),path(Z,Y).
