package io.pavan;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCoder {
    HashMap<Character, String> encoder;
    HashMap<String,Character> decoder;

    public class Node implements Comparable<Node>{
        private Character data;
        private int cost;
        private Node left;
        private Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right= null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost -  other.cost;
        }
    }

    public HuffmanCoder(String feeder) throws Exception {
        HashMap<Character,Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {
            char ch = feeder.charAt(i);
            if(frequencyMap.containsKey(ch)){
                int ov = frequencyMap.get(ch);
                ov+=1;
                frequencyMap.put(ch,ov);
            }else{
                frequencyMap.put(ch,1);
            }
        }
        Heap<Node> minHeap = new Heap<>();
        Set<Map.Entry<Character, Integer>> entrySet = frequencyMap.entrySet();
        for (Map.Entry<Character,Integer> entry: entrySet){
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }
        while(minHeap.size()!=1){
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node('\0', first.cost+second.cost);
            newNode.left= first;
            newNode.right=second;

            minHeap.insert(newNode);
        }
        Node ft = minHeap.remove();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoder(ft,"");

    }

    private void initEncoderDecoder(Node node, String osf) {
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            this.encoder.put(node.data, osf);
            this.decoder.put(osf,node.data);
        }
        initEncoderDecoder(node.left,osf+"0");
        initEncoderDecoder(node.right,osf+"1");
    }
    public StringBuilder encode(String str){
        String ans ="";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(encoder.get(str.charAt(i)));
        }
        return sb;
    }
    public StringBuilder decode(StringBuilder codeString){
        String key ="";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < codeString.length(); i++) {
            key = key+ codeString.charAt(i);
            if(decoder.containsKey(key)){
                sb.append(decoder.get(key));
                key="";
            }
        }
        return sb;
    }

    public static void main(String[] args) throws Exception {
        String str = "abbcda";
        HuffmanCoder coder = new HuffmanCoder(str);
        StringBuilder es = coder.encode(str);
        System.out.println(es);
        StringBuilder ds = coder.decode(es);
        System.out.println(ds);
    }
}
