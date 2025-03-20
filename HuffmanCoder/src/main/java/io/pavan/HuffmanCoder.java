package io.pavan;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCoder {
    HashMap<Character, String> encoder;
    HashMap<String,Character> decoder;
    private class Node implements Comparable<Node>{
        Character data;
        int cost;
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left=null;
            this.right=null;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public HuffmanCoder(String feeder) throws Exception{
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0;i< feeder.length();i++){
            char ch = feeder.charAt(i);
            if(freqMap.containsKey(ch)){
                int ov = freqMap.get(ch);
                ov+=1;
                freqMap.put(ch,ov);
            }else {
                freqMap.put(ch,1);
            }
        }
        Heap<Node> minHeap = new Heap<>();
        Set<Map.Entry<Character, Integer>> entrySet = freqMap.entrySet();
        for (Map.Entry<Character,Integer> entry : entrySet){
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }
        while(minHeap.size()!=1){
            Node first = minHeap.remove();
            Node second = minHeap.remove();
            Node newNode = new Node('\0', first.cost+ second.cost);
            newNode.left=first;
            newNode.right=second;
            minHeap.insert(newNode);
        }
        Node ft = minHeap.remove();
        this.encoder= new HashMap<>();
        this.decoder= new HashMap<>();
        this.initEncoderDecoder(ft,"");
    }

    private void initEncoderDecoder(Node node, String osf) {
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            this.encoder.put(node.data,osf);
            this.decoder.put(osf,node.data);
        }
        initEncoderDecoder(node.left, osf+'0');
        initEncoderDecoder(node.right, osf+'1');
    }
    public String encoder(String source){
        StringBuilder ans =new StringBuilder();
        for(int i=0;i<source.length();i++){
         ans.append(encoder.get(source.charAt(i)));
        }
        return ans.toString();
    }
    public String decoder(String encodedString){
        String key ="";
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<encodedString.length();i++){
            key+=encodedString.charAt(i);
            if(decoder.containsKey(key)){
                ans.append(decoder.get(key));
                key="";
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) throws Exception {
        String str = "pavan";
        HuffmanCoder hf = new HuffmanCoder(str);
        String eS= hf.encoder(str);
        System.out.println(eS);
        String dS = hf.decoder(eS);
        System.out.println(dS);
    }
}
