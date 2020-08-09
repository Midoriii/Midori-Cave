package com.apprehension.midoricave.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data class of a Spirit, the basis of this project, so I can keep
 * ledgers on spirits I'd love to try
 * 
 * @author Midoriii
 * 
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bottles")
public class Bottle {

}
