%{
#include <stdio.h>
int nums = 0,words = 0,new = 0, ids = 0;
%}
%%

[0-9]  nums++;
[a-zA-z]+  words++;ids++;
[\n]  new++;
[a-z_A-z][0-9a-z_A-z]*[0-9a-zA-z] ids++;
.  ;
%%
int main()
{
printf ("This Lex program counts the number of Digits, Words, Lines & Identifiers ");
printf ("\nEnter the text and terminate it with CTRL-d.\n");
yylex();
printf (" Numbers = %d.\n Words = %d.\n Lines = %d.\n Ids = %d.\n", nums, words, new, ids);
return 0;
}
int yywrap()
{
return 1;
}
/*
INPUT
warren 678ty
874fff _ty

OUTPUT
warren 678ty
874fff _ty
*/
