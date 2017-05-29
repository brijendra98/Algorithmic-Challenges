#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
 
bool check_report(char *x, int len) {
 
  int h = 0;
  int t = 0;
 
  for(int i = 0;i<len;i++) {
    if(x[i] == 'H') {
      h++;
    }
    else if(x[i] == 'T') {
      t++;
    }
    if(t>h || (h-t>1)) {
      return false;
    }
  }
  
  if(h==t) {
  return true;
  }
  else {
    return false;
  }
}
 
int main(void) {
 
  int n;
  scanf("%d",&n);
 
  for(int i = 0;i<n;i++) {
    int e;
    scanf("%d",&e);
    char *arr = malloc((e+1)*sizeof(char));
 
    scanf("%s",arr);
    arr[e]=0;
 
    if(check_report(arr,e) == true) {
      printf("Valid\n");
    }
    else {
      printf("Invalid\n");
    }
    free(arr);
  }
}
