#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#define N 500000
void quickSort(int[], int, int);
int partition(int[], int, int);
int main(){
    clock_t startTime = clock();
    FILE *file;
    file = fopen("../../array.txt", "r");
    int array[N];
    int i;
    for (i = 0; i < N; i++){
        fscanf(file, "%d\n", &array[i] );
    }
    fclose(file);
    clock_t endFileTime = clock();
    quickSort(array, 0, N-1);
    clock_t endTime = clock();
    double fileTime = (double)(endFileTime - startTime) / (double)CLOCKS_PER_SEC;
    double quickSortTime = (double)(endTime - endFileTime) / (double)CLOCKS_PER_SEC;
    double totalTime = (double)(endTime - startTime) / (double)CLOCKS_PER_SEC;
    printf("Total of numbers: %d\n",N);
    printf("File time: %f seconds\n",fileTime);
    printf("Quick Sort time: %f seconds\n",quickSortTime);
    printf("Total time: %f seconds\n",totalTime);
    return 0;
}
void quickSort(int arr[], int left, int right) {
    int index = partition(arr, left, right);
    if(left < index - 1) {
        quickSort(arr, left, index - 1);
    }
    if(index < right) {
        quickSort(arr, index, right);
    }
}
int partition(int arr[], int left, int right) {
    int i = left, j = right;
    int tmp;
    int pivot = arr[(left + right) / 2];
    while(i <= j) {
        while(arr[i] < pivot) {
            i++;
        }
        while(arr[j] > pivot) {
            j--;
        }
        if(i <= j) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
    return i;
}
