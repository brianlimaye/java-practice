#include <stdio.h>
#include <stdlib.h>

//To compile: gcc -o main main.c
int main(int argc, char ** argv)
{
	fprintf(stdout, "Thank you for calling my program. You passed in %i arguments", argc);
	return 0;
}