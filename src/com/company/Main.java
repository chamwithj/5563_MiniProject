package com.company;

public class Main {
    public static void main(String[] args) {
        int[] memorySizes = {200, 300, 100, 500, 50};
        NextFitAllocator allocator = new NextFitAllocator(memorySizes);

        allocator.displayMemory();
        allocator.allocate(120);
        allocator.allocate(450);
        allocator.deallocate(0, 120);
        allocator.allocate(90);
        allocator.displayMemory();
    }
}

