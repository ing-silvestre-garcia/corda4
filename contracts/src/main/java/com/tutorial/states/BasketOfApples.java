package com.tutorial.states;

import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.ConstructorForDeserialization;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@BelongsToContract(BasketofApplesContract.class)
public class BasketOfApples implements ContractState {

    //Variables internas
    private String description;
    private Party farm;
    private Party owner;
    private int weight;
    private List<AbstractParty> participants;

    public BasketOfApples(String description, Party farm, int weight) {
        this.description = description;
        this.farm = farm;
        this.weight = weight;
        this.participants = new ArrayList<AbstractParty>();
        this.participants.add(farm);
    }

    @ConstructorForDeserialization
    public BasketOfApples(String description, Party farm, Party owner, int weight) {
        this.description = description;
        this.farm = farm;
        this.owner = owner;
        this.weight = weight;
        this.participants = new ArrayList<AbstractParty>();
        this.participants.add(farm);
        this.participants.add(owner);
    }

    public String getDescription() {
        return description;
    }

    public Party getFarm() {
        return farm;
    }

    public Party getOwner() {
        return owner;
    }

    public int getWeight() {
        return weight;
    }

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return participants;
    }

    public BasketOfApples changeOwner(Party buyer){
        BasketOfApples newOwnerState = new BasketOfApples(this.description,this.farm,buyer,this.weight);
        return newOwnerState;
    }
}
