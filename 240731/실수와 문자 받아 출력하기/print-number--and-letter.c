#include <stdio.h>

int main() {
    char c;
    double a, b;

    scanf("%c", &c);
    scanf("%lf %lf", &a, &b);

    printf("%c\n", c);
    printf("%.2lf\n", a);
    printf("%.2lf", b);

    return 0;
}