#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int main(void) {

  int T;
  scanf("%d",&T);

  for(int i = 0;i<T;i++) {
    int n,m;
    scanf("%d %d",&n,&m);
    if(n%2 == 0) {
      printf("yes\n");
    }
    else {
      printf("no\n");
    }
    for(int j=0;j<m;j++) {
      int u,v;
      scanf("%d %d", &u, &v);
    }
  }
}
