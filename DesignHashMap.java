
//TimeComplexity 
//get O(1)
//put O(1)
//remove 0(1)


class MyHashMap {
    
    ListNode[] nodes = new ListNode[10000];

    
    public MyHashMap() { //initialized the nodes array
        
    }
    
    private int getIndex(int key) {
        return Integer.hashCode(key)%10000;
    }
    
    private ListNode findElement(int index, int key) {
        ListNode node = nodes[index];
        if(node == null) {
            return nodes[index] = new ListNode(-1,-1);
        }
        while (node.next!= null && node.next.key!=key )
        {
            node=node.next;
        }
        return node;
    }
    
    public void put(int key, int value) {
        int index= getIndex(key);
        ListNode prev= findElement(index, key);
        if(prev.next == null) {
            prev.next = new ListNode(key,value);
        }
        else {
            prev.next.val=value;
        } 
    }
    
    public int get(int key) {
        int index= getIndex(key);
        ListNode prev= findElement(index, key);
        
        if(prev.next ==null){
            return -1;         
        }
        else {
            return prev.next.val;
        }
    }
    
    public void remove(int key) {
        int index= getIndex(key);
        ListNode prev= findElement(index, key);
        if(prev.next != null){
         prev.next= prev.next.next;
        }
    }
    
    
    class ListNode{
        int key;
        int val;
        ListNode next; 
        
        //parameterized constructor
        ListNode(int key, int value){
            this.key = key;
            this.val = value;
        }    
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
