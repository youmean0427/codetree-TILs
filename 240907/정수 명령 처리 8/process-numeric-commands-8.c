#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node{
    int data;
    struct node *prev;
    struct node *next; 
} node;

typedef struct doubly_list
{
    node *head;
    node *tail;
    int size;
} doubly_list;

// 구조체의 포인터에 접근할 때는 ->를 사용
void    init(doubly_list *list)
{
    list->head = NULL;
    list->tail = NULL;
    list->size = 0;
}

void    push_back(doubly_list *list, int data)
{
    // 새로운 Node를 생성, 주소로 받음
    node *new_node = (node *)malloc(sizeof (node));
    
    new_node->data = data;
    new_node->next = NULL;

    // Doubly_list에 Node가 있는지 판단
    if (list->size == 0)
    {
        list->tail = new_node;
        list->head = new_node;
        new_node->prev = NULL;
        new_node->next = NULL;
        list->size++;
    }
    else
    {
        new_node->prev = list->tail;
        list->tail->next = new_node;
        list->tail = new_node;
        list->size++;
    }
}

void    push_front(doubly_list *list, int data)
{
    node *new_node = (node *)malloc(sizeof(node));

    new_node->data = data;
    new_node->prev = NULL;

    if (list->size == 0)
    {
        new_node->next = NULL;
        list->head = new_node;
        list->tail = new_node;
        list->size++;
    }
    else
    {
        new_node->next = list->head;
        list->head->prev = new_node;
        list->head = new_node;
        list->size++;
    }
}

void    pop_front(doubly_list *list)
{
    if (list->size == 0)
        return ;
    else if (list->size == 1)
    {
        printf("%d\n", list->head->data);
        list->head = NULL;
        list->tail = NULL;
        list->size--;
    }
    else {
        printf("%d\n", list->head->data);
        list->head = list->head->next;
        list->head->prev = NULL;
        list->size--;
    }
}

void    pop_back(doubly_list *list)
{
    if (list->size == 0)
        return ;
    else if (list->size == 1)
    {
        printf("%d\n", list->tail->data);
        list->head = NULL;
        list->tail = NULL;
        list->size--;
    }
    else
    {
        printf("%d\n", list->tail->data);
        list->tail = list->tail->prev;
        // list->tail->next->prev = NULL;
        list->tail->next = NULL;
        list->size--;
    }
    return ;
}

void    size(doubly_list *list)
{
    printf("%d\n", list->size);
    return ;
}

void    empty(doubly_list *list)
{
    if (list->size)
        printf("0\n");
    else
        printf("1\n");
    return ;
}

void    front(doubly_list *list)
{
    if (list->size)
        printf("%d\n", list->head->data);
    else
        return ;
}

void    back(doubly_list *list)
{
    if (list->size)
        printf("%d\n", list->tail->data);
    else
        return ;
}

int main() {
    
    int n;
    char s[20];
    int d;
    doubly_list d_list;

    scanf("%d", &n);
    init(&d_list);
    for (int i = 0; i < n; i++)
    {
        scanf("%s", s);
        if (strcmp(s, "push_front") == 0)
        {   
            scanf("%d", &d);
            push_front(&d_list, d);
        }
        else if (strcmp(s, "push_back") == 0)
        {
            scanf("%d", &d);
            push_back(&d_list, d);
        }
        else if (strcmp(s, "pop_front") == 0)
            pop_front(&d_list);
        else if (strcmp(s, "pop_back") == 0)
            pop_back(&d_list);
        else if (strcmp(s, "size") == 0)
            size(&d_list);
        else if (strcmp(s, "empty") == 0)
            empty(&d_list);
        else if (strcmp(s, "front") == 0)
            front(&d_list);
        else if (strcmp(s, "back") == 0)
            back(&d_list);
    }
    return 0;
}