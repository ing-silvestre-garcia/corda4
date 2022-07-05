package com.tutorial.states;

import com.tutorial.contracts.AppleStampContract;
import net.corda.core.contracts.BelongcToContract;
import net.corda.core.contracts.LinearState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.ConstructForDeserialization;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@BelongsToContract(AppleStampContract.class) //A que contrato va ligado
public class AppleStamp implements LinearState {

    //Variables Privadas personalizadas
    private String stampDesc; //Descripcion
    private Party issuer; //persona que edita el sello
    private Party holder; //persona dueña del sello

    //Variable obligatoria para clase LinearState
    private UniqueIdentifier LinearID;
    //Parametro de estado de corda donde indica los participantes
    private List<AbstractParty> participants;

    @ConstructorForDeserialization
    public AppleStamp(String stampDesc, String issuer, String holder, UniqueIdentifier linearID, List<AbstractParty> participants) {
        this.stampDesc = stampDesc;
        this.issuer = issuer;
        this.holder = holder;
        this.LinearID = linearID;
        this.participants = new ArrayList<AbstractParty>();
        this.participants.add(issuer);
        this.participants.add(holder);
    }

    public String getStampDesc() {
        return stampDesc;
    }

    public Party getIssuer() {
        return issuer;
    }

    public Party getHolder() {
        return holder;
    }

    public UniqueIdentifier getLinearID() {
        return LinearID;
    }

    public List<AbstractParty> getParticipants() {
        return participants;
    }
}