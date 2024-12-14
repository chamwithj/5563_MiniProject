package com.company;

public class MemoryBlock {
    int size;
    boolean allocated;

    public MemoryBlock(int size) {
        this.size = size;
        this.allocated = false;
    }
}
