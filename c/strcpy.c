#include<stdio.h>

char * strcpy(char * dst, const char * src){
  char * ptr;
  ptr = dst;
  while((*ptr++ = *src++) != '\0')
    ;
  return dst;
}

char * strcpy2(char dst[], const char source[]){
  int i = 0;
  while(source[i] != '\0'){
    dst[i] = source[i];
    i++;
  }
  dst[i] = '\0';
  return dst;
}

int main(){
  char str[] = "october";
  char dst[40];
  char dst2[40];
  strcpy(dst, str);
  strcpy2(dst2, str);
  printf("dst: %s dst2: %s\n", dst, dst2);
  return 0;
}
