% 1
sublist([],[]).
sublist( S, L ) :-append([_, S, _], L ).


%2
shift([], []).
shift([H|T], L) :- append(T, [H], L).


%3
divide([],[],[]).
divide([A],[A],[]).
divide([A,B|X],[A|S],[B|D]):-divide(X,S,D).


%4
%maxlist([M],M).


%5
ordered([]).
ordered([_]).
ordered([X,Y|Z]):-X=<Y,ordered([Y|Z]).


%6
%gcd(N1, N2, G).
