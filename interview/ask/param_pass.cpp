#include<stdio.h>

class Wrapper{
  public:
    Wrapper(int i = 0){
      dig = i;
    }
    int & getDig(){
      return dig;
    }
  private:
    int dig;
};

void mul(int & a ){
  a = 2 * a;
}

int main(){
  Wrapper w(1);
  mul(w.getDig());
  printf("%d\n", w.getDig());
  return 0;
}
