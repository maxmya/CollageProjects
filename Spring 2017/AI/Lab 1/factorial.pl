factorial(0,1).

factorial(X,L):-
    Y is X-1
    factorial(Y,J),J is L * X.

