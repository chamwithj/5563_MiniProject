package com.company;

import java.util.ArrayList;

public class NextFitAllocator {
    private ArrayList<MemoryBlock> memoryBlocks;
    private int lastPosition;

    public NextFitAllocator(int[] memorySizes) {
        memoryBlocks = new ArrayList<>();
        for (int size : memorySizes) {
            memoryBlocks.add(new MemoryBlock(size));// Converts each memory size into a MemoryBlock and adds it to the memoryBlocks list.
        }
        lastPosition = 0;
    }

    public boolean allocate(int processSize) {
        int n = memoryBlocks.size();
        for (int i = 0; i < n; i++) {
            int position = (lastPosition + i) % n;
            MemoryBlock block = memoryBlocks.get(position);
            if (!block.allocated && block.size >= processSize) {
                block.size -= processSize;
                block.allocated = true;
                lastPosition = position;
                System.out.println("Allocated " + processSize + " KB to Block " + position + ".");
                return true;
            }
        }
        System.out.println("Failed to allocate " + processSize + " KB.");
        return false;
    }

    public void deallocate(int blockIndex, int size) {
        if (blockIndex >= 0 && blockIndex < memoryBlocks.size()) {
            MemoryBlock block = memoryBlocks.get(blockIndex);
            block.size += size;
            block.allocated = false;
            System.out.println("Deallocated " + size + " KB from Block " + blockIndex + ".");
        } else {
            System.out.println("Invalid block index.");
        }
    }

    public void displayMemory() {
        System.out.println("Memory Blocks:");
        for (int i = 0; i < memoryBlocks.size(); i++) {
            MemoryBlock block = memoryBlocks.get(i);
            String status = block.allocated ? "Allocated" : "Free";
            System.out.println("Block " + i + ": " + block.size + " KB (" + status + ")");
        }
    }
}
