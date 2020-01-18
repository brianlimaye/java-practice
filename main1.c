#include <stdio.h>
#include <stdlib.h>

int main(int argc, char ** argv)
{
	char c;
	int is_running = 1;

	fprintf(stdout, "<<Please enter input. Q to exit.\n");
	fflush(stdout);
	while(is_running)
	{
		c = fgetc(stdin);
		fprintf(stdout, "%c\n", c);
		fflush(stdout);
		if(c == 'Q')
		{
			fprintf(stdout, "MAGIC\n");
			fflush(stdout);
		}
	}

}