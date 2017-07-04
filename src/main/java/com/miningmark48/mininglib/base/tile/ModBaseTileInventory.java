package com.miningmark48.mininglib.base.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nullable;

public class ModBaseTileInventory extends TileEntity implements IInventory{

    private String customName;
    private int INV_SIZE;
    private NonNullList<ItemStack> inventory = NonNullList.withSize(INV_SIZE, ItemStack.EMPTY);

    /**
     * Basic Tile Entity for an inventory-based block.
     * @param inventorySize
     *  Int value for number of slots the inventory has for storing.
     */
    public ModBaseTileInventory(int inventorySize){
        this.INV_SIZE = inventorySize;
    }

    @Override
    public int getSizeInventory() {
        return this.INV_SIZE;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.inventory)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        if (index < 0 || index >= this.getSizeInventory()){
            return ItemStack.EMPTY;
        }
        return inventory.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        if (this.getStackInSlot(index) != null){
            ItemStack itemStack;

            if (this.getStackInSlot(index).getCount() <= count){
                itemStack = this.getStackInSlot(index);
                this.setInventorySlotContents(index, ItemStack.EMPTY);
                this.markDirty();
                return itemStack;
            }else{
                itemStack = this.getStackInSlot(index).splitStack(count);
                if (this.getStackInSlot(index).getCount() <= 0){
                    this.setInventorySlotContents(index, ItemStack.EMPTY);
                }

                this.markDirty();
                return itemStack;
            }
        }else {
            return ItemStack.EMPTY;
        }
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = getStackInSlot(index);
        setInventorySlotContents(index, ItemStack.EMPTY);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        if (index < 0 || index >= this.getSizeInventory()){
            return;
        }

        if (stack != ItemStack.EMPTY && stack.getCount() > this.getInventoryStackLimit()){
            stack.setCount(this.getInventoryStackLimit());
        }

        if (stack != ItemStack.EMPTY && stack.getCount() == 0){
            stack = ItemStack.EMPTY;
        }

        this.inventory.set(index, stack);
        this.markDirty();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getName() {
        return customName;
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.equals("");
    }

    public void setCustomName(String customName){
        this.customName = customName;
    }

    @Nullable
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.customName) : new TextComponentString(world.getBlockState(pos).getBlock().getLocalizedName());
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);

        NBTTagList list = new NBTTagList();
        for (int i = 0; i < this.getSizeInventory(); i++){
            if (this.getStackInSlot(i) != null){
                NBTTagCompound stackTag = new NBTTagCompound();
                stackTag.setByte("Slot", (byte) i);
                this.getStackInSlot(i).writeToNBT(stackTag);
                list.appendTag(stackTag);
            }
        }

        nbt.setTag("Items", list);

        if (this.hasCustomName()){
            nbt.setString("CustomName", this.getDisplayName().toString());
        }

        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        NBTTagList list = nbt.getTagList("Items", 10);
        for (int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound stackTag = list.getCompoundTagAt(i);
            int slot = stackTag.getByte("Slot") & 255;
            this.setInventorySlotContents(slot, new ItemStack(stackTag));
        }

        if (nbt.hasKey("CustomName", 8)) {
            this.setCustomName(nbt.getString("CustomName"));
        }

    }
}
