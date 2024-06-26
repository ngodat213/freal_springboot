package com.example.frealsb.Modules.FriendRequest.Model;

import com.example.frealsb.Common.AbstractEntity;
import com.example.frealsb.Modules.User.Model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class FriendRequest extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "requester_id")
    private User requester;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private String status; // "PENDING", "ACCEPTED", "DECLINED"
}