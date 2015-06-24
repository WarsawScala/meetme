package pl.warsawscalania.meetme.model

/**
 * Created by marun on 24.06.2015.
 */
case class Position(lat: Double, long :Double, user : String)

case class Output( users : Seq[Position] )

