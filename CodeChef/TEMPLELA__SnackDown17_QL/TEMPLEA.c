#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
 
bool check_seq(int *x, int len) {
  
  if(len%2 == 0) {
    return false;
  }
  
  int acc = 1;
  for (int i=0;i<len/2;i++) {
    
    if(x[i] != x[len-1-i] || x[i] != acc) {
      return false;
    }
    acc++;
  }
  return true;
}
 
int main(void) {
  
  int n;
  scanf("%d",&n);
  
  for(int i = 0;i<n;i++) {
    int e;
    scanf("%d",&e);
    int *arr = malloc(e*sizeof(int));
    
    for(int j=0;j<e;j++) {
      scanf("%d",(arr+j));
    }
    
    if(check_seq(arr,e) == true) {
      printf("yes\n");
    }
    else {
      printf("no\n");
    }
    free(arr);
  }
}
