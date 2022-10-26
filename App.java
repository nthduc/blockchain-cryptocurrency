package com.globalsoftwaresupport;

public class App {
	public static void main(String[] args) {
		System.out.println(SHA256Helper.generateHash("Hello World"));
		System.out.println(SHA256Helper.generateHash("Hello World"));
		System.out.println(SHA256Helper.generateHash(SHA256Helper.generateHash("Hello World")));
		
		for(Integer i = 0 ; i < 100; i++) {
			System.out.println(SHA256Helper.generateHash(i.toString()));
		}
		
		BlockChain blockChain = new BlockChain();
		Miner miner = new Miner();
		
		//we can create the blocks one by one
		Block block0 = new Block(0, "", Constants.GENESIS_PREV_HASH);
		miner.mine(block0,blockChain);
		Block block1 = new Block(1,"transaction1", blockChain.getBlockChain().get(blockChain.getSize()- 1).getHash());
		miner.mine(block1,blockChain);
		Block block2 = new Block(2,"transaction2", blockChain.getBlockChain().get(blockChain.getSize()- 1).getHash());
		miner.mine(block2, blockChain);
		
		System.out.println("\n" + "BLOCKCHAIN:\n"+blockChain);
		System.out.println("Miner's reward:" + miner.getReward());
		
	}
}
